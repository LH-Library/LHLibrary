<template>
<main class="container">
  <FormReader />
</main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import FormReader from '@/components/FormReader.vue';

export default defineComponent({
    name: "EditReaderView",
    props: {
    },
    components: { FormReader }
});
</script>

<style lang="scss">
main {
  margin: 100px 0;
}
</style>
