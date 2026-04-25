<template>
    <div class="container">
        <div class="contatiner-1">
            <InfoLogin :logueado="logueado" />
        </div>
        <div>
            <FormLogin :logueado="logueado" />
        </div>
    </div>
</template>

<script setup lang="ts">
import InfoLogin from '@/components/LoginComp/InfoLogin.vue'
import FormLogin from '@/components/LoginComp/FormLogin.vue'

const logueado = false
</script>

<style lang="scss" scoped>
.container {
    display: flex;
    align-items: stretch;
    gap: 30px;
    margin: 40px 25px;
    justify-content: center;
    flex-wrap: wrap;
}
</style>
