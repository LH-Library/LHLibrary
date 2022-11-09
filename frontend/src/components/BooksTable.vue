<template>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Código</th>
                <th scope="col">Título</th>
                <th scope="col">Autor</th>
                <th scope="col">Gênero</th>
                <th scope="col">Local</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(book, i) in books" :key="i">
                <th scope="row">{{book.id}}</th>
                <td>{{book.titulo}}</td>
                <td>{{book.autor}}</td>
                <td>{{book.genero}}</td>
                <td>{{book.local}}</td>
            </tr>
        </tbody>
    </table>
</template>
<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: 'BooksTable',
    props: { books: {type: Array} },
    methods: {
        async searchBooks() {
            const req = await fetch(`http://localhost:8081/api/v1/livros?=${this.search}`);
            const data = await req.json();

            return data;
        }
    },
    data() {
        return {
        }
    }
})
</script>

<style>

</style>