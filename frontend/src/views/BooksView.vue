<template>
  <main class="container">
    <div class="d-flex justify-content-between">
      <SearchBar />
      <button type="button" class="btn btn-danger" @click="goToAddBookPage">Adicionar</button>
    </div>
    <div class="mt-5">
      <BooksTable :books="this.books" />
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SearchBar from '@/components/SearchBar.vue';
import BooksTable from '@/components/BooksTable.vue';

export default defineComponent({
  name: "BooksView",
  props: {
  },
  components: { SearchBar, BooksTable },
  methods: {
    goToAddBookPage() {
      this.$router.push({ name: 'livros-novo' })
    },
    async getBooks() {
      const req = await fetch(`http://localhost:8081/api/v1/livros`)
      const data = await req.json();

      console.log(data);
      this.books = data;
    }
  },
  mounted() {
      this.getBooks();
  },
  data() {
    return {
      books: []
    }
  }
});
</script>

<style lang="scss">
main {
  margin: 100px 0;
}
</style>
