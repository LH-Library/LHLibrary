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
            <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            </tr>
            <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            </tr>
            <tr>
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: 'BooksTable',
    methods: {
        async searchBooks() {
            const req = await fetch(`http://localhost:8081/api/v1/livros?=${this.search}`);
            const data = await req.json();

            return data;
        }
    },
    data() {
        return {
            
        }
    }
})
</script>

<style>

</style>