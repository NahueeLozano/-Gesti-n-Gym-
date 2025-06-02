# 🏋️‍♂️ Gestión Gym - Administración de gimnasios

Gestión Gym es una aplicación de escritorio desarrollada en Java para la gestión integral de gimnasios. Permite administrar usuarios, membresías, pagos y actividades, brindando un control eficiente sobre las operaciones de los socios.

## 🔗 Integración con MundoGymPhp
Este sistema de escritorio está vinculado con la plataforma web MundoGymPhp, lo que permite gestionar información desde ambas interfaces de manera sincronizada.

## 🚀 Características principales
✔ Registro y administración de usuarios.  
✔ Control y seguimiento de membresías.  
✔ Gestión de pagos y vencimientos.  
✔ Visualización de actividades disponibles en el gimnasio.  
✔ Interfaz intuitiva y fácil de usar (Swing).  

## 🏗️ Arquitectura
La estructura del código está organizada en tres capas:

- **Modelo:** Entidades y acceso a datos (`Usuario`, `Membresia`, `Pago`, `Conexion`, `Gestion`).
- **Controlador:** Manejo de la lógica de negocio (`Controlador`, `zonaGym`).
- **Vista:** Interfaz gráfica (`Menu`, `vistaPagos`, `VistaUsuarios`).

## 🛠 Instalación y ejecución
1️⃣ Clonar el repositorio:

```sh
git clone https://github.com/NahueeLozano/-Gesti-n-Gym-.git
```

2️⃣ Abrir el proyecto en NetBeans o tu IDE Java preferido.  
3️⃣ Configurar la conexión a la base de datos en `Conexion.java`.  
4️⃣ Compilar y ejecutar el proyecto desde `zonaGym.java`.  

---

📌 Este sistema está diseñado para facilitar la administración de gimnasios y mejorar la experiencia tanto de propietarios como de usuarios.