<template>
    <div class="alert" :class="{ 'alert-success': success, 'alert-danger': !success }" v-show="showAlert" role="alert">
        {{ success ? "Envio realizado com sucesso." : "Falha ao realizar envio." }}
    </div>
</template>
    
<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
    name: 'RequestAlert',
    props: {
        show: { type: Boolean },
        success: { type: Boolean }
    },
    emits: ['showAlert'],
    watch: {
        show() {
            if (!this.show) return;
            this.showAlert = this.show;
            setTimeout(() => {
                this.showAlert = !this.show;
                this.$emit('showAlert', false)
            }, 2000);
        }
    },
    data() {
        return {
            showAlert: false
        }
    }
})
</script>