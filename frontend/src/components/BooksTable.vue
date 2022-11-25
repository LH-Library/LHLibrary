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
            <tr v-for="(book, i) in books" :key="i" @click="goToDetailsBookPage(book.id)">
                <th scope="row">{{ book.id }}</th>
                <td>{{ book.titulo }}</td>
                <td>{{ book.autor }}</td>
                <td>{{ book.genero }}</td>
                <td>{{ book.local }}</td>
            </tr>
        </tbody>
    </table>
</template>
<script lang="ts">
import IBook from "@/interfaces/IBook";
import { defineComponent, PropType } from "vue";

export default defineComponent({
    name: 'BooksTable',
    props: { books: { type: Array as PropType<IBook[]> } },
    methods: {
        goToDetailsBookPage(id: number) {
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
    color: #3f3f3f;
    text-decoration: none;
    
}
tbody {
    tr {
        &:hover {
            cursor: pointer;
        }
    }
}
</style>