<template>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Código</th>
                <th scope="col">Título</th>
                <th scope="col" v-if="showAuthorColumn">Autor</th>
                <th scope="col" v-if="showLocalColumn">Local</th>
                <th scope="col" v-if="showActionColumn" >Ação</th>
            </tr>
        </thead>
        <tbody v-if="!showActionColumn">

            <tr v-for="(book, i) in books" :key="i" @click="goToDetailsBookPage(book.id)">
                <th scope="row">{{ book.id }}</th>
                <td>{{ book.titulo }}</td>
                <td v-if="showAuthorColumn">{{ book.autor }}</td>
                <td v-if="showLocalColumn">{{ book.local }}</td>
            </tr>

        </tbody>

        <tbody v-else>
            <tr v-for="(book, i) in books" :key="i">
                <th scope="row">{{ book.id }}</th>
                <td>{{ book.titulo }}</td>
                <td v-if="showAuthorColumn">{{ book.autor }}</td>
                <td v-if="showLocalColumn">{{ book.local }}</td>
                <td v-if="showActionColumn"><button class="btn btn-secondary" @click="bookAction(book,i)">{{ showLocalColumn ? "+" : "-" }}</button></td>
            </tr>
        </tbody>
    </table>
</template>
<script lang="ts">
import { defineComponent, PropType } from "vue";

export default defineComponent({
    name: 'BooksTable',
    emits: ['bookAction'],
    props: {
        books: { type: Array as PropType<any[]> },
        showLocalColumn: { type: Boolean },
        showActionColumn: { type: Boolean },
        showAuthorColumn: { type: Boolean }
    },
    methods: {
        goToDetailsBookPage(id: number) {
            this.$router.push({ name: 'livros-detalhes', params: { id: id } })
        },
        bookAction(book: any, i: any) {
            const actionBook = {
                book: book,
                index: i}
            this.$emit("bookAction", actionBook);
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