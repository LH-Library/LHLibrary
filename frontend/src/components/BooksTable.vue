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
                <th scope="row">{{ book.id }}</th>
                <td><a class="title-link" @click="goToDetailsBookPage(book.id)">{{ book.titulo }}</a></td>
                <td>{{ book.autor }}</td>
                <td>{{ book.genero }}</td>
                <td>{{ book.local }}</td>
            </tr>
        </tbody>
    </table>
</template>
<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: 'BooksTable',
    props: { books: { type: Array } },
    methods: {
        goToDetailsBookPage(id) {
            this.$router.push({ name: 'livros-detalhes', params: { id: id } })
        }
    },
    data() {
        return {
        }
    }
})
</script>

<style lang="scss">
.title-link {
    font-weight: 600;
    color: #3f3f3f;
    text-decoration: none;
    &:hover {
        color: #7b0000;
        cursor: pointer;
    }
}
</style>