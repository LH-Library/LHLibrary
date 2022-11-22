<template>
<main class="container">
  <div class="d-flex justify-content-between w-100">
    <SearchBar @searchResult="printSearchedBooks" :customPlaceholder="'Título, autor ou gênero'" :endpoint="'livros'"/>
    <button type="button" class="btn btn-danger" @click="goToAddBookPage">Adicionar</button>
  </div>
  <div class="mt-5 w-100">
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
    printSearchedBooks(books : IBook[]) {
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
