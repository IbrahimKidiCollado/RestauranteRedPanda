<template>
  <div class="contenedor-admin">
    <div class="formulario-adicion">
      <h2 class="titulo-panel">SELECCIONA EL ELEMENTO A AÑADIR</h2>
      
      <div class="seleccion-elemento">
        <label for="entidad">Seleccione el elemento a introducir: </label>
        <select id="entidad">
          <option value="" disabled selected>-- Elige una opción --</option>
          <option value="sushi">Sushi 🍣</option>
          <option value="ramen">Ramen 🍜</option>
          <option value="entrante">Entrante 🥟</option>
          <option value="bebida">Bebida 🍺</option>
          <option value="carne">Carne 🥩</option>
          <option value="pescado">Pescado 🐟</option>
          <option value="postre">Postre 🍰</option>
        </select>
      </div>

      <div class="introduccion-datos">
        <div class="campo">
          <label for="nombre">Introduzca su nombre: </label>
          <input id="nombre" type="text" placeholder="nombre.....">
        </div>
        
        <div class="campo">
          <label for="descripcion">Descripción del elemento: </label>
          <input id="descripcion" type="text" placeholder="elemento con.....">
        </div>

        <div class="campo">
          <label for="precio">Precio en €: </label>
          <input id="precio" type="text" placeholder="17€.....">
        </div>

        <div class="campo">
          <label for="cantidad">Cantidad: </label>
          <input id="cantidad" type="number" placeholder="2.....">
        </div>

        <button type="submit" class="boton-enviar">AÑADIR A LA CARTA</button>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.contenedor-admin {
  background-color: #000000;
  min-height: 60vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px 20px;

  .formulario-adicion {
    scroll-margin-top: 100px;
    width: 100%;
    max-width: 600px;
    background-color: #050505;
    padding: 40px;
    border-radius: 20px;
    border: 1px solid $color-rojo-oscuro;
    border-bottom: 4px solid $color-rojo-panda;
    text-align: center;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);

    .titulo-panel {
      color: $color-rojo-panda;
      font-size: 24px;
      font-weight: 700;
      margin-bottom: 30px;
      text-transform: uppercase;
    }

    .seleccion-elemento {
      margin-bottom: 30px;
      display: flex;
      flex-direction: column;
      gap: 10px;
      align-items: center;

      label {
        color: $color-rojo-claro;
        font-weight: 600;
      }
    }

    .introduccion-datos {
      display: flex;
      flex-direction: column;
      gap: 20px;

      .campo {
        display: flex;
        justify-content: space-between;
        align-items: center;
        gap: 15px;

        label {
          flex: 1;
          text-align: right;
          color: #ffffff;
          font-size: 14px;
        }

        input {
          flex: 1.5;
        }
      }
    }

    input, select {
      padding: 12px 15px;
      background-color: #121212;
      border: 1px solid $color-rojo-oscuro-claro;
      border-radius: 10px;
      color: #ffffff;
      outline: none;
      transition: all 0.3s ease;

      &:focus {
        border-color: $color-rojo-panda;
        box-shadow: 0 0 8px rgba($color-rojo-panda, 0.2);
      }
    }

    .boton-enviar {
      margin-top: 20px;
      padding: 15px;
      background-color: $color-rojo-oscuro;
      color: #ffffff;
      border: 1px solid $color-rojo-panda;
      border-radius: 10px;
      font-weight: 700;
      cursor: pointer;
      transition: all 0.3s ease;

      &:hover {
        background-color: $color-rojo-panda;
        transform: translateY(-3px);
        box-shadow: 0 5px 15px rgba($color-rojo-panda, 0.3);
      }
    }
  }
}

option {
  background-color: #121212;
  color: #ffffff;
}
</style>