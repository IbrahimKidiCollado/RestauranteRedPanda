<script setup lang="ts"></script>

<template>
  <header>
    <div class="contenedor-imagen-nombre">
      <img src="/assets/logo.png" alt="Logo Profesional">
      <div class="contenedor-titulo">
        <h1 class="marca-nombre">Red Panda</h1>
        <h2 class="marca_definicion">Sabores Autenticos</h2>
      </div>
    </div>
    <nav class="contenedor-enlaces">
      <li>Inicio</li>
      <li>Tienda</li>
    </nav>
    <div class="contenedor-carrito-perfil">
      <button class="carrito"></button>
      <button class="perfil"></button>
    </div>
  </header>
  <main>

  </main>
  <footer>

  </footer>
</template>

<style lang="scss" scoped>
  header {
    display: flex;

    .contenedor-imagen-nombre {
      display: flex;

      img {
        width: 100px;
        height: 80px;
      }
    }
  }

  

</style>