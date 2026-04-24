<template>
    <div>
        <InfoLogin :logueado="logueado" />
    </div>
    <div>
        <FormLogin :logueado="logueado" />
    </div>
</template>

<script setup lang="ts">
import InfoLogin from '@/components/LoginComp/InfoLogin.vue'
import FormLogin from '@/components/LoginComp/FormLogin.vue'

const logueado = false
</script>

<style lang="scss" scoped></style>
