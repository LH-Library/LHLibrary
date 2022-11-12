<template>
    <div>
        <div class="input-group has-validation">
            <span class="input-group-text" >Pesquisar</span>
            <div class="form-floating" :class="{'is-invalid': noResultsFound}">
                <input type="text" class="form-control" :class="{'is-invalid': noResultsFound}" id="floatingInputGroup2" placeholder="Título, autor ou gênero" v-model="search">
                <label for="floatingInputGroup2">Pesquisa</label>
            </div>
            <div v-show="noResultsFound" class="invalid-feedback">
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
            const req = await fetch(`http://localhost:8081/api/v1/livros?filtro=${this.search}`);
            const data = await req.json();
            this.noResultsFound = data.length == 0;
            this.$emit("searchedBooks", data);
            return data;
        }
    },
    watch: {
        async search() {
            this.searchBooks();
        }
    },
    mounted() {
        this.searchBooks();
    },
    data() {
        return {
            search: "",
            noResultsFound: false
        }
    }
})
</script>

<style>

</style>