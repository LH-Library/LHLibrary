<template>
<form id="form-new-book" @submit="createBook">
    <div class="row">
        <div class="col">
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="titulo">Título</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="titulo"
                    id="titulo"
                    v-model="titulo"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="autor">Autor</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="autor"
                    id="autor"
                    v-model="autor"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="editora">Editora</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="editora"
                    id="editora"
                    v-model="editora"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="edicao">Edição</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="edicao"
                    id="edicao"
                    v-model="edicao"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="idioma">Idioma</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="idioma"
                    id="idioma"
                    v-model="idioma"
                    type="text">
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="paginas">Páginas</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="paginas"
                    id="paginas"
                    v-model="paginas"
                    type="number">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="generos">Gêneros</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="generos"
                    id="generos"
                    v-model="generos"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="isbn">ISBN</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="isbn"
                    id="isbn"
                    v-model="isbn"
                    type="text">
                </div>
            </div>
            <div class="row g-3 align-items-center mt-3">
                <div class="col-3">
                    <label class="form-label" for="local">Local</label>
                </div>
                <div class="col-auto">
                    <input
                    class="form-control"
                    name="local"
                    id="local"
                    v-model="local"
                    type="text">
                </div>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-5">Submit</button>
</form>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'FormBook',
    methods:{
        async getBookInformation(id: number) {
            const req = await fetch(`http://localhost:8081/api/v1/livros/${id}`)
            const data = await req.json();
            
            console.log(data)
        },
        async createBook(e) {
            e.preventDefault();

            const data = {
                titulo: this.titulo,
                autor: this.autor,
                editora: this.editora,
                edicao: this.edicao,
                idioma: this.idioma,
                paginas: this.paginas,
                generos: this.generos,
                status: this.status,
                isbn: this.isbn,
                ativo: this.ativo,
                local: this.local
            }
            
            const dataJson = JSON.stringify(data);

            const req = await fetch("http://localhost:8081/api/v1/livros", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: dataJson
            });

            const res = await req.json();

            console.log(res);

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
            generos: null,
            status: "Disponível",
            isbn: null,
            ativo: true,
            local: null
        }
    }
});
</script>
  
<style lang="scss">
</style>
  