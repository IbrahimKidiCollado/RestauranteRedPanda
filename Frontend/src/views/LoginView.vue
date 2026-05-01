<template>
    <div class="container">
        <div v-if="!activo" class="contatiner-1">
            <InfoLogin :logueado="logueado" />
        </div>
        <div v-if="!activo">
            <FormLogin :logueado="logueado" />
        </div>
        <div>
            <UserInfo v-if="activo" />
        </div>
        <div v-if="activo">
            <HistorialPedidos />
        </div>
    </div>
</template>

<script setup lang="ts">
import InfoLogin from '@/components/LoginComp/InfoLogin.vue'
import FormLogin from '@/components/LoginComp/FormLogin.vue'
import { useUserStore } from '@/stores/userStore'
import { computed } from 'vue'
import UserInfo from '@/components/LoginComp/UserInfo.vue'
import HistorialPedidos from '@/components/LoginComp/HistorialPedidos.vue'

const userStore = useUserStore()
const logueado = computed(() => userStore.logueado)
const activo = computed(() => userStore.sesionActiva)
</script>

<style lang="scss" scoped>
@keyframes slideFromLeft {
    0% {
        opacity: 0;
        transform: translateX(-100px);
    }
    100% {
        opacity: 1;
        transform: translateX(0);
    }
}

@keyframes slideFromRight {
    0% {
        opacity: 0;
        transform: translateX(100px);
    }
    100% {
        opacity: 1;
        transform: translateX(0);
    }
}

.container {
    display: flex;
    align-items: stretch;
    gap: 30px;
    margin: 40px 25px;
    justify-content: center;
    flex-wrap: wrap;

    > div:nth-child(odd) {
        animation: slideFromLeft 0.8s ease-out both;
    }

    > div:nth-child(even) {
        animation: slideFromRight 0.8s ease-out both;
    }
}
</style>
