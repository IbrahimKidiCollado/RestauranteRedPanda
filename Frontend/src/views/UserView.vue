<template>
    <div class="contenedor">
        <div>
            <userInfo />
        </div>
        <div>
            <HistorialPedidos />
        </div>
    </div>

</template>
<script lang="ts" setup>
import UserInfo from '@/components/UserComp/UserInfo.vue'
import HistorialPedidos from '@/components/UserComp/HistorialPedidos.vue'

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

.contenedor {
    display: flex;
    flex-direction: column;
    align-items: center;
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