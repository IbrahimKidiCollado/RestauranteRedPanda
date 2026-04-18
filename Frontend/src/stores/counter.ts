import { ref, computed, watch } from 'vue'
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

  const envioMinimoGratis:number = 35;
  const precioEnvio:number = 4.99;

  const carritoGuardado = localStorage.getItem('carrito-redpanda');
  const productosCarrito = ref<ProductoCarrito[]>(carritoGuardado ? JSON.parse(carritoGuardado) : []);

  watch (
    productosCarrito,
    (carritoNuevo) => {
      localStorage.setItem('carrito-redpanda', JSON.stringify(carritoNuevo));
    },
    { deep: true }
  )

  const cantidadProductosCarrito = computed(() => productosCarrito.value.length);

  const subtotal = computed(() => {
    return productosCarrito.value.reduce((total, productoCarrito) => total + productoCarrito.precio * (productoCarrito.cantidad ?? 1), 0);
  })

  const envio = computed<number>(() => subtotal.value >= envioMinimoGratis ? 0 : precioEnvio);
  const envioRestante = computed<number>(() => envioMinimoGratis - subtotal.value);

  const total = computed<number>(() => subtotal.value + envio.value);

  const añadirProducto = (producto: Producto) => {
    
    const productoExiste: ProductoCarrito | undefined = productosCarrito.value.find(p => p.id === producto.id);
    
    if (productoExiste) productoExiste.cantidad++;
    else productosCarrito.value.push({...producto,cantidad: 1});
  }

  const eliminarProducto = (producto: ProductoCarrito) => {
    productosCarrito.value = productosCarrito.value.filter(p => p.id !== producto.id);
  }

  const sumarCantidadProducto = (producto: ProductoCarrito) => {producto.cantidad++}
  const restarCantidadProducto = (producto: ProductoCarrito) => {
    if (producto.cantidad === 1) eliminarProducto(producto);
    else producto.cantidad--;
  }

  return {
    // Productos
    productosCarrito,
    
    // Cantidades
    subtotal,
    cantidadProductosCarrito,
    envio,
    total,
    envioRestante,
    
    // Acciones
    añadirProducto,
    eliminarProducto,
    sumarCantidadProducto,
    restarCantidadProducto
  };
});