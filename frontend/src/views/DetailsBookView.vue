<template>
<main class="container">
  <div class="row">
    <div class="col-md-5">
      <h1>Título:<br /><span>{{ titulo }}</span></h1>
      <h5>Author: <span>{{ autor }}</span></h5>
      <h5>Editora: <span>{{ editora }}</span></h5>
      <h5>Edição: <span>{{ edicao }}</span></h5>
      <h5>Idiomas: <span>{{ idioma }}</span></h5>
      <h5>Páginas: <span>{{ paginas }}</span></h5>
      <h5>Gênero: <span>{{ genero }}</span></h5>
    </div>
    <div class="col-md-4">
      <h5>Código: <span>{{ id }}</span></h5>
      <h5>ISBN: <span>{{ isbn }}</span></h5>
      <h5>Local: <span>{{ local }}</span></h5>
      <h5>Status: <span>{{ status === "DISPONIVEL" ? "Disponível" : "Indisponível" }}</span></h5>
    </div>
    <div class="col-md-3 d-flex flex-column justify-content-between">
      <button type="button" class="btn btn-danger" disabled>Remover</button>

      <button type="button" class="btn btn-danger" disabled>Locar</button>

      <button type="button" class="btn btn-danger" disabled>Duplicar</button>

      <button type="button" class="btn btn-danger" @click="goToEditBookPage" disable>Editar</button>
    </div>
  </div>
</main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: "DetailsBookView",
    props: {
    },
    methods:{
        async getBookInformation(id: string | string[]) {
            const req = await fetch(`http://localhost:8081/api/v1/livros/${id}`)
            const data = await req.json();
            
            console.log(data);

            this.titulo = data.titulo,
            this.autor = data.autor,
            this.editora = data.editora,
            this.edicao = data.edicao,
            this.idioma = data.idioma,
            this.paginas = data.paginas,
            this.genero = data.genero,
            this.status = data.status,
            this.isbn = data.isbn,
            this.ativo = data.ativo,
            this.local = data.local
        },
        goToEditBookPage() {
          this.$router.push({name: 'livros-editar', params: { id: this.id  } })
        }
    },
    mounted() {
        if (this.id != null) {
            this.getBookInformation(this.id);
        }
    },
    data() {
        return {
            id: this.$route.params.id,
            titulo: null,
            autor: null,
            editora: null,
            edicao: null,
            idioma: null,
            paginas: null,
            genero: null,
            status: "DISPONIVEL",
            isbn: null,
            ativo: true,
            local: null
        }
    }
});
</script>

<style lang="scss">
main {
  margin: 100px 0;
}
buttton {
  color: #7b0000;
}
h1{
  font-weight: bold;
  font-size: 1rem;
  text-align: left;
  span {
    font-size: 1.5rem;
    font-weight: lighter;
    color: #7b0000;
  }
}
h5{
  margin-top: 2rem;
  font-weight: bold;
  text-align: left;
  font-size: 1.3;
  span{
    font-weight: lighter;
    font-size: 1.2rem;
  }
}
</style>
