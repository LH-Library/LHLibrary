<template>
    <div>
        <div class="input-group has-validation">
            <div class="form-floating" :class="{'is-invalid': noResultsFound}">
                <input type="text" class="form-control" :class="{'is-invalid': noResultsFound}" id="floatingInputGroup2" v-bind:placeholder="customPlaceholder" v-model="search">
                <label for="floatingInputGroup2">Pesquisa</label>
            </div>
            <div v-show="noResultsFound" class="invalid-feedback">
                Nenhum resultado encontrado
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
    name: 'SearchBar',
    emit: ['searchResult'],
    props: {
        customPlaceholder: String,
        endpoint: String
    },
    methods: {
        async searchResult() {
            const req = await fetch(`http://localhost:8081/api/v1/${this.endpoint}?filtro=${this.search}`);
            const data = await req.json();
            this.noResultsFound = data.length == 0;
            this.$emit("searchResult", data);
            return data;
        }
    },
    watch: {
        async search() {
            this.searchResult();
        }
    },
    mounted() {
        this.searchResult();
    },
    data() {
        return {
            search: "",
            noResultsFound: false
        }
    }
})
</script>

<style lang="scss">

</style>