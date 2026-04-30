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
    async function obtenerPedidos(idUsuario: number) {
            console.log('Obteniendo pedidos para el usuario con ID:', idUsuario);
            const res = await fetch(`http://localhost:8081/pedidos/${idUsuario}`);
            const data = await res.json();
            console.log('Pedidos obtenidos:', data);
            return data;
    }

    return{
        realizarPedido,
        obtenerPedidos
    }
});