<template>
    <main class="container w-100">
        <div class="row">
            <div class="col">
                <div class="d-flex justify-content-between w-100">
                    Leitor: <SearchBar @searchResult="printSearchedBooks" :customPlaceholder="'Título, autor ou gênero'"
                        :endpoint="'livros'" />
                </div>
                <div class="d-flex justify-content-between w-100">
                    Livro: <SearchBar @searchResult="printSearchedBooks" :customPlaceholder="'Título, autor ou gênero'"
                        :endpoint="'livros'" />
                </div>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
        </div>
        <div class="mt-5">
            <BooksTable :books="books" />
        </div>
    </main>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';
import SearchBar from '@/components/SearchBar.vue';
import BooksTable from '@/components/BooksTable.vue';
import IBook from '@/interfaces/IBook';

export default defineComponent({
    name: "BooksView",
    props: {
    },
    components: { SearchBar, BooksTable },
    methods: {
        goToAddBookPage() {
            this.$router.push({ name: 'livros-novo' })
        },
        printSearchedBooks(books: IBook[]) {
            this.books = books
        }
    },
    data() {
        return {
            books: [] as IBook[]
        }
    }
});
</script>
  
<style lang="scss">

</style>
  