import {defineStore} from 'pinia'
import { ref } from 'vue';
import { annadirPedido } from '@/services/Tienda/PedidoService';

export const usePedidoStore = defineStore('pedido', () => {

    async function realizarPedido(idUsuario: number, total: number, productos: any[]) {
        //mostrar por consola como si fuese un json
        console.log('Realizando pedido con los siguientes datos:');
        const res = await annadirPedido(idUsuario, total, productos);
         console.log('Respuesta del servidor:', res);
    }

    return{
        realizarPedido
    }
});