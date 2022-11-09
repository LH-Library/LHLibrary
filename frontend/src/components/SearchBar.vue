<template>
    <div>
        <div class="input-group has-validation">
            <span class="input-group-text" >Pesquisar</span>
            <div class="form-floating is-invalid">
                <input type="text" class="form-control is-invalid" id="floatingInputGroup2" placeholder="Título, autor ou gênero" v-model="search">
                <label for="floatingInputGroup2">Pesquisa</label>
            </div>
            <div class="invalid-feedback">
                Nenhum resultado encontrado
            </div>
        </div>
        <div>{{searchBooks}}</div>
    </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: 'SearchBar',
    methods: {
    
    },
    computed: {
        searchBooks() {
            const req = fetch(`http://localhost:8081/api/v1/livros?filtro=${this.search}`);
            const data = req.json();

            console.log(data);

            return data;
        }
    },
    data() {
        return {
            search: ""
        }
    }
})
</script>

<style>

</style>