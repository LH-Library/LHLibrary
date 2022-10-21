<template>
<main class="container">
  <FormNewBook />
</main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import FormNewBook from '@/components/FormNewBook.vue';

export default defineComponent({
    name: "BookView",
    props: {
    },
    components: { FormNewBook }
});
</script>

<style lang="scss">
main {
  margin: 100px 0;
}
</style>
