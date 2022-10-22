<template>
<form id="form-new-book">
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
                    <label class="form-label" for="isbn">Local</label>
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
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-5">Submit</button>
</form>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'FormNewBook',
    methods:{
        async getBooks() {
            const req = await fetch("http://")
        }
    },
    data() {
        return {
            titulo: "Corações feridos",
            autor: "John Snow",
            editora: "Blabla",
            edicao: "10S",
            idioma: "Portugẽs",
            paginas: 100,
            generos: ["Terror", "Romance"],
            isbn: "3512-B",
            local: "B-12"
        }
    }
});
</script>
  
<style lang="scss">
</style>
  