<template>
    <div class="contenedor">
        <h2 class="titulo">{{ $t('historialPedidos.titulo') }}</h2>
            
        <table class="tabla-pedidos">
            <thead>
                <tr>
                <th>{{ $t('historialPedidos.tabla.id') }}</th>
                <th>{{ $t('historialPedidos.tabla.info') }}</th>
                <th>{{ $t('historialPedidos.tabla.total') }}</th>
                </tr>
            </thead>
            <tbody class="cuerpo-carta">
                <tr v-for="pedido in listaPedidos" :key="pedido.id" class="fila-plato">
                <td>
                    <div class="celda-nombre">
                    <strong># {{ pedido.id }}</strong>
                    </div>
                </td>
                <td>
                    <div class="celda-categoria">
                    <span>{{ pedido.lineasPedido.length }} productos</span>
                    </div>
                </td>
                <td>
                    <div class="celda-precio">
                    {{ pedido.precio }} €
                    </div>
                </td>
                </tr>
            </tbody>
        </table>

        <div v-if="listaPedidos.length === 0" class="sin-pedidos">
            <p>{{ $t('historialPedidos.detalles.vacio') }}</p>
        </div>
    </div>
</template>

<script setup lang="ts">
import { useUserStore } from '@/stores/userStore';
import { usePedidoStore } from '@/stores/pedidoStore';
import { computed, onMounted } from 'vue';

const userStore = useUserStore();
const pedidoStore = usePedidoStore();

const listaPedidos = computed(() => pedidoStore.pedidos || []);

onMounted(async () => {
    if (userStore.id) {
        await pedidoStore.obtenerPedidos(userStore.id);
    }
});
</script>

<style lang="scss" scoped>

.contenedor {
    padding: 2rem;
    background-color: $color-fondo-tarjeta;
    border: 1px $color-rojo-oscuro-claro solid;
    border-radius: 15px;
    display: flex;
    flex-direction: column;
    .titulo{
        color: $color-texto-blanco;
    }

    .tabla-pedidos {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 10px;

        th {
            color: $color-gris;
            text-align: left;
            padding: 10px;
            font-size: 0.8rem;
        }
        .cuerpo-carta {
            .fila-plato {
                background-color: $color-fondo-main;
                transition: all 0.3s ease;

                &:hover {
                    background-color: $color-fondo-controles;
                    transform: scale(1.01);
                }

                td {
                    padding: 15px;
                    color: $color-texto-blanco;
                    .celda-nombre strong {
                        color: $color-rojo-panda;
                    }

                    .celda-categoria span {
                        background: rgba($color-texto-blanco, 0.1);
                        padding: 4px 10px;
                        border-radius: 20px;
                        font-size: 0.8rem;
                        color: $color-blanco-sucio;
                    }

                    .celda-precio {
                        font-weight: bold;
                        color: $color-texto-blanco;
                    }
                }
            }
        }
    }
    .sin-pedidos {
        color: $color-blanco-sucio;
        text-align: center;
        padding: 2rem;
    }

}
</style>