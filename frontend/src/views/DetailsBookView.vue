<template>
  <main class="container">
    <div class="row">
      <div class="col-md-10">
        <div class="row">
          <div class="col-md-6">
            <h1 class="header-attribute">Título:<br /><span>{{ book.titulo }}</span></h1>
          </div>
          <div class="col-md-6">
            <h5 class="header-attribute">Código:<br /><span>{{ book.id }}</span></h5>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <h5 class="default-attribute">Autor: <span>{{ book.autor }}</span></h5>
            <h5 class="default-attribute">Editora: <span>{{ book.editora }}</span></h5>
            <h5 class="default-attribute">Edição: <span>{{ book.edicao }}</span></h5>
            <h5 class="default-attribute">Idiomas: <span>{{ book.idioma }}</span></h5>
            <h5 class="default-attribute">Páginas: <span>{{ book.paginas }}</span></h5>
            <h5 class="default-attribute">Gênero: <span>{{ book.genero }}</span></h5>
          </div>
          <div class="col-md-6">
            <h5 class="default-attribute">ISBN: <span>{{ book.isbn }}</span></h5>
            <h5 class="default-attribute">Local: <span>{{ book.local }}</span></h5>
            <h5 class="default-attribute">Status: <span>{{ book.status === "DISPONIVEL" ? "Disponível" : "Indisponível"
            }}</span>
            </h5>
          </div>
        </div>
      </div>
      <div class="col-md-2 d-flex flex-column justify-content-evenly">
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
  methods: {
    getBookInformation(id: string | string[]) {
      fetch(`http://localhost:8081/api/v1/livros/${id}`)
        .then((response) => {
          return response.json();
        })
        .then((data) => this.book = data)
        .catch((error) => console.log(error));
    },
    goToEditBookPage() {
      this.$router.push({ name: 'livros-editar', params: { id: this.book.id } })
    }
  },
  mounted() {
    if (this.book.id != null) {
      this.getBookInformation(this.book.id);
    }
  },
  data() {
    return {
      book: {
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

.default-attribute {
  margin-top: 2rem;
  font-weight: bold;
  text-align: left;
  font-size: 1.3;

  span {
    font-weight: lighter;
    font-size: 1.2rem;
  }
}

.header-attribute {
  font-weight: bold;
  font-size: 1rem;
  text-align: left;

  span {
    font-size: 1.5rem;
    font-weight: lighter;
    color: #7b0000;
  }
}
</style>
