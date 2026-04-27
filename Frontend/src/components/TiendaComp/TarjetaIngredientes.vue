<template>
    <div class="overlay-modal" @click.self="$emit('cerrar')">
        <div class="modal-container">
            <div class="modal-header">
                <div class="title-group">
                    <span class="material-symbols-outlined icon-red"> chef_hat </span>
                    <h2>{{ $t('ingredientes.pers') }}</h2>
                </div>
                <span class="material-symbols-outlined close-btn" @click="$emit('cerrar')">
                    close
                </span>
            </div>

            <div class="dish-info">
                <p class="dish-name">{{ nombre }}</p>
                <p class="instruction">{{ $t('ingredientes.select') }}</p>
            </div>

            <div class="contenedor-ingredientes">
                <label
                    v-for="ingrediente in ingredientes"
                    :key="ingrediente.id"
                    class="opcion-ingrediente"
                    :for="'ingrediente-' + ingrediente.id"
                >
                    <span class="ingrediente-nombre">{{ ingrediente.nombre }}</span>

                    <input
                        type="checkbox"
                        :id="'ingrediente-' + ingrediente.id"
                        v-model="ingredientesSeleccionados"
                        :value="ingrediente.id"
                        @click="seleccionar(ingrediente.id, ingrediente.nombre)"
                    />
                </label>
            </div>

            <div class="modal-footer">
                <div class="price-group">
                    <p class="price-label">{{ $t('ingredientes.precio') }}</p>
                    <p class="price-amount">€{{ precio }}</p>
                </div>
                <div class="action-buttons">
                    <button class="btn-cancel" @click="$emit('cerrar')">
                        {{ $t('ingredientes.cancel') }}
                    </button>
                    <button @click="añadirAlCarrito()" class="btn-add">{{ $t('ingredientes.añadir') }}</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'



const router = useRouter()

//Seleccionamos los ingredientes que vamos a quitar
const seleccionar = (id: number, nombre: string) => {
    ingredientesSeleccionados.value.push(id);
    listaIngredientesQuitados.value += nombre + ', ';
}

const añadirAlCarrito = () => {
    //Lanzo un emit para decir que añada al carrito el plato con los ingredientes quitados
    emit('añadir', { ingredientesSeleccionados: ingredientesSeleccionados.value, listaIngredientesQuitados: listaIngredientesQuitados.value })
}

interface Ingrediente {
    id: number
    nombre: string
}

const ingredientesSeleccionados = ref<number[]>([])
const listaIngredientesQuitados = ref<string>('')

defineProps<{
    nombre: string
    precio: number
    ingredientes: Ingrediente[]
}>()

const emit = defineEmits(['cerrar', 'añadir'])
</script>

<style scoped lang="scss">
$bg-dark: #050505;
$bg-card: #000000;
$border-dark-red: #3a0e0e;
$accent-red: #e60000;
$hover-red: #ff1a1a;
$text-white: #ffffff;
$text-grey: #a0a0a0;

.overlay-modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.7);
    backdrop-filter: blur(8px);
    -webkit-backdrop-filter: blur(8px);
    z-index: 9999;
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-container {
    background-color: $bg-dark;
    border: 1px solid $border-dark-red;
    border-radius: 16px;
    padding: 30px;
    width: 90%;
    max-width: 600px;
    color: $text-white;
    box-shadow: 0 15px 40px rgba(0, 0, 0, 0.8);

    .modal-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;

        .title-group {
            display: flex;
            align-items: center;
            gap: 10px;

            .icon-red {
                color: $accent-red;
                font-size: 28px;
            }

            h2 {
                margin: 0;
                font-size: 22px;
                font-weight: 700;
            }
        }

        .close-btn {
            color: $text-grey;
            cursor: pointer;
            transition: color 0.1s;
            &:hover {
                color: $text-white;
            }
        }
    }

    .dish-info {
        border-bottom: 1px solid #1a1a1a;
        padding-bottom: 20px;
        margin-bottom: 20px;

        .dish-name {
            color: $accent-red;
            font-size: 18px;
            font-weight: 600;
            margin: 0 0 5px 0;
        }

        .instruction {
            color: $text-grey;
            font-size: 14px;
            margin: 0;
        }
    }

    .contenedor-ingredientes {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 15px;
        margin-bottom: 30px;

        @media (max-width: 480px) {
            grid-template-columns: 1fr;
        }
    }

    .opcion-ingrediente {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: $bg-card;
        border: 1px solid $border-dark-red;
        border-radius: 12px;
        padding: 16px 20px;
        cursor: pointer;
        transition: border-color 0.3s ease;

        .ingrediente-nombre {
            font-size: 15px;
            font-weight: 500;
        }

        input[type='checkbox'] {
            appearance: none;
            -webkit-appearance: none;
            width: 22px;
            height: 22px;
            border: 2px solid $border-dark-red;
            border-radius: 50%;
            background-color: transparent;
            cursor: pointer;
            outline: none;
            transition: all 0.2s ease-in-out;
        }

        &:hover {
            border-color: $hover-red;

            input[type='checkbox'] {
                border-color: $hover-red;
                transform: scale(1.15);
            }
        }

        input[type='checkbox']:checked {
            background-color: $accent-red;
            border-color: $accent-red;
        }
    }

    .modal-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
        border-top: 1px solid #1a1a1a;
        padding-top: 20px;

        .price-group {
            .price-label {
                color: $text-grey;
                font-size: 13px;
                margin: 0 0 4px 0;
            }

            .price-amount {
                color: $accent-red;
                font-size: 26px;
                font-weight: 700;
                margin: 0;
            }
        }

        .action-buttons {
            display: flex;
            gap: 12px;

            button {
                border: none;
                border-radius: 10px;
                padding: 12px 24px;
                font-size: 15px;
                cursor: pointer;
                transition:
                    background-color 0.3s ease,
                    transform 0.1s ease;

                &:active {
                    transform: scale(0.96);
                }
            }

            .btn-cancel {
                background-color: #1f1f1f;
                color: $text-white;
                font-weight: 500;

                &:hover {
                    background-color: #2e2e2e;
                }
            }

            .btn-add {
                background-color: $accent-red;
                color: $text-white;
                font-weight: 600;

                &:hover {
                    background-color: $hover-red;
                }
            }
        }
    }
}
</style>
