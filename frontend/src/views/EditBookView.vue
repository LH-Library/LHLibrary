<template>
<main class="container">
  <FormBook />
</main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import FormBook from '@/components/FormBook.vue';

export default defineComponent({
    name: "EditBookView",
    props: {
    },
    components: { FormBook }
});
</script>

<style lang="scss">
main {
  margin: 100px 0;
}
</style>
