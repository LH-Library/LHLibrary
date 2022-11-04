<template>
    <div>
        <div class="input-group has-validation">
            <span class="input-group-text">Pesquisar</span>
            <div class="form-floating is-invalid">
                <input type="text" class="form-control is-invalid" id="floatingInputGroup2"
                    placeholder="Título, autor ou gênero" required>
                <label for="floatingInputGroup2">Pesquisa</label>
            </div>
            <div class="invalid-feedback">
                Nenhum resultado encontrado
            </div>
        </div>
    </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: 'SearchBar',
    methods: {
        async searchBooks() {
            const req = await fetch(`http://localhost:8081/api/v1/livros?=${this.search}`);
            const data = await req.json();

            return data;
        },
    },
    data() {
        return {
            books: [{
                titulo: "",
                autor: "",
                editora: "",
                edicao: "",
                idioma: "",
                paginas: "",
                generos: "",
                status: "",
                isbn: "",
                ativo: "",
                local: ""
            }],
            search: ""
        }
    }
})
</script>

<style>

</style>