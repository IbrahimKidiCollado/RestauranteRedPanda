import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCarritoStore = defineStore('carrito', () => {

  interface Producto{
    id: number;
    nombre: string;
    precio: number;
    imagen: string;
    descripcion: string;
    categoria_slug: string;
  };

  interface ProductoCarrito extends Producto {
    cantidad: number;
  }

  const productosCarrito = ref<ProductoCarrito[]>([]);

  const cantidadProductosCarrito = computed(() => productosCarrito.value.length);

  const subtotal = computed(() => {
    return productosCarrito.value.reduce((total, productoCarrito) => total + productoCarrito.precio * (productoCarrito.cantidad ?? 1), 0);
  })

  const envio = computed<number>(() => subtotal.value >= 35 ? 0 : 4.99);

  const añadirProducto = (producto: Producto) => {
    
    const productoExiste: ProductoCarrito | undefined = productosCarrito.value.find(p => p.id === producto.id);
    
    if (productoExiste) productoExiste.cantidad++;
    else productosCarrito.value.push({...producto,cantidad: 1});
    
    return {subtotal, cantidadProductosCarrito, envio}
  }
});