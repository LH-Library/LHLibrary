<template>
  <main class="container">
    <div class="d-flex justify-content-between w-100">
      <SearchBar @searchResult="printSearchedReaders" :customPlaceholder="'Nome ou CPF'" :endpoint="'leitor'"/>
      <button type="button" class="btn btn-danger" @click="goToAddReaderPage">Adicionar</button>
    </div>
    <div class="mt-5 w-100">
      <ReadersTable :readers="readers" />
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SearchBar from '@/components/SearchBar.vue';
import ReadersTable from '@/components/ReadersTable.vue';
import IReader from '@/interfaces/IReader';

export default defineComponent({
  name: "ReadersView",
  props: {
  },
  components: { SearchBar, ReadersTable },
  methods: {
    goToAddReaderPage() {
      this.$router.push({ name: 'leitores-novo' })
    },
    printSearchedReaders(readers : IReader[]) {
      this.readers = readers
    }
  },
  data() {
    return {
      readers: [] as IReader[]
    }
  }
});
</script>

<style lang="scss">
</style>
