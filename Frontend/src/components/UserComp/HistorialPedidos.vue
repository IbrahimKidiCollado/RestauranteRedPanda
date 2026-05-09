<template>
    <div class="contenedor">
        <h2 class="titulo">{{ $t('historialPedidos.titulo') }}</h2>

        <table class="tabla-pedidos">
            <thead>
                <tr>
                    <th class="titulo-fila"></th>
                    <th class="titulo-fila">{{ $t('historialPedidos.tabla.total') }}</th>
                </tr>
            </thead>
            <tbody class="cuerpo-carta">
                <!--Cada pedido del usuario :)-->
                <template v-for="pedido in listaPedidos" :key="pedido.id">
                    <tr
                        class="fila-plato"
                        :class="{ 'fila-activa': pedidoSeleccionadoId === pedido.id }"
                        @click="Detalle(pedido.id)"
                    >
                        <td class="datos">
                            <div class="id">
                                <strong># {{ pedido.id }}</strong>
                            </div>
                        </td>
                        <td class="datos">
                            <div class="precio-total">{{ Number(pedido.precio).toFixed(2) }} €</div>
                        </td>
                    </tr>

                    <!--Esto es lo que se despliega al pulsar sobre un pedido :)-->
                    <tr v-if="pedidoSeleccionadoId === pedido.id" class="fila-detalle">
                        <td colspan="3">
                            <div class="detalle-pedido">
                                <div class="lista-productos">
                                    <div v-for="linea in pedido.lineasPedido" class="item-linea">
                                        <div class="fila-producto">
                                            <div class="info-plato">
                                                <span class="cantidad">{{ linea.cantidad }}x</span>
                                                <span class="nombre">{{ linea.nombrePlato }}</span>
                                            </div>
                                            <span class="precio-linea">{{ linea.precio }} €</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="resumen-total">
                                    <span>Total pagado:</span>
                                    <strong>{{ Number(pedido.precio).toFixed(2) }} €</strong>
                                </div>
                            </div>
                        </td>
                    </tr>
                </template>
            </tbody>
        </table>

        <div v-if="listaPedidos.length === 0" class="sin-pedidos">
            <p>{{ $t('historialPedidos.detalles.vacio') }}</p>
        </div>
    </div>
</template>

<script setup lang="ts">
import { useUserStore } from '@/stores/userStore'
import { usePedidoStore } from '@/stores/pedidoStore'
import { computed, onMounted, ref } from 'vue'

const userStore = useUserStore()
const pedidoStore = usePedidoStore()

const listaPedidos = computed(() => pedidoStore.pedidos || [])

const pedidoSeleccionadoId = ref<number | null>(null)

const Detalle = (id: number) => {
    pedidoSeleccionadoId.value = pedidoSeleccionadoId.value === id ? null : id
}

onMounted(async () => {
    if (userStore.id) {
        await pedidoStore.obtenerPedidos(userStore.id)
    }
})
</script>

<style lang="scss" scoped>
.contenedor {
    padding: 3rem;
    background: $color-rojo-degradado;
    border: 1px $color-rojo-oscuro-claro solid;
    border-radius: 15px;
    display: flex;
    flex-direction: column;

    .titulo {
        color: $color-texto-blanco;
        font-size: 26px;
    }

    .tabla-pedidos {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 8px;

        .titulo-fila {
            color: $color-gris;
            text-align: left;
            padding: 0 15px;
            font-size: 20px;
        }

        .cuerpo-carta {
            .fila-plato {
                background-color: $color-fondo-main;
                transition: all 0.2s ease;
                cursor: pointer;

                &:hover {
                    background-color: $color-fondo-controles;
                }

                &.fila-activa {
                    background-color: $color-fondo-controles;
                    border-left: 3px solid $color-rojo-panda;
                }

                .datos {
                    padding: 20px 15px;
                    color: $color-texto-blanco;

                    .id strong {
                        color: $color-rojo-panda;
                    }

                    .precio-total {
                        font-weight: bold;
                    }
                }
            }

            .fila-detalle {
                .detalle-pedido {
                    background-color: rgba(0, 0, 0, 0.2);
                    padding: 20px;
                    border-radius: 0 0 12px 12px;
                    border: 1px solid rgba($color-rojo-panda, 0.2);
                    border-top: none;
                    animation: slideDown 0.3s ease-out;

                    .lista-productos {
                        display: flex;
                        flex-direction: column;
                    }

                    .item-linea {
                        padding: 10px 0;
                        border-bottom: 1px solid rgba(255, 255, 255, 0.05);

                        &:last-child {
                            border-bottom: none;
                        }

                        .fila-producto {
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            gap: 20px;
                        }

                        .info-plato {
                            display: flex;
                            gap: 12px;

                            .cantidad {
                                color: $color-rojo-panda;
                                font-weight: bold;
                            }

                            .nombre {
                                color: $color-texto-blanco;
                                font-size: 0.95rem;
                            }
                        }

                        .precio-linea {
                            color: $color-blanco-sucio;
                            font-size: 0.9rem;
                        }
                    }

                    .resumen-total {
                        margin-top: 15px;
                        padding-top: 15px;
                        border-top: 1px dashed rgba(255, 255, 255, 0.1);
                        display: flex;
                        justify-content: flex-end;
                        align-items: center;
                        gap: 15px;
                        color: $color-texto-blanco;

                        strong {
                            font-size: 1.2rem;
                            color: $color-rojo-panda;
                        }
                    }
                }
            }
        }
    }

    .sin-pedidos {
        color: $color-blanco-sucio;
        text-align: center;
        padding: 3rem;
    }
}

@keyframes slideDown {
    from {
        opacity: 0;
        transform: translateY(-5px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}
</style>
