<template>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">E-mail</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(reader, i) in readers" :key="i" @click="goToDetailsReaderPage(reader.id)">
                <th scope="row">{{ reader.id }}</th>
                <td>{{ reader.nome }}</td>
                <td>{{ reader.email }}</td>
            </tr>
        </tbody>
    </table>
</template>
<script lang="ts">
import IReader from "@/interfaces/IReader";
import { defineComponent, PropType } from "vue";

export default defineComponent({
    name: 'ReaderTable',
    props: { readers: { type: Array as PropType<IReader[]> } },
    methods: {
        goToDetailsReaderPage(id: string | number) {
            this.$router.push({ name: 'leitores-detalhes', params: { id: id } })
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