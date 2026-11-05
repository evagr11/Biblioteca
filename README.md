<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:1C2B2A,50:2F6B5E,100:C8963E&height=200&section=header&text=Mi%20biblioteca&fontSize=60&fontColor=fff&fontAlignY=38&desc=Gesti%C3%B3n%20de%20los%20libros%20de%20casa%20en%20JavaFX%20%7C%20Patr%C3%B3n%20MVC&descAlignY=62&descSize=18" width="100%"/>
</div>

<div align="center">
  <a href="https://github.com/evagr11/Biblioteca" target="_blank">
    <img src="https://img.shields.io/badge/Ver_Código-2F6B5E?style=for-the-badge&logo=github&logoColor=white" alt="Ver Código"/>
  </a>
  <a href="https://github.com/evagr11/Biblioteca/releases/latest" target="_blank">
    <img src="https://img.shields.io/badge/Descargar_para_Windows-C8963E?style=for-the-badge&logo=windows&logoColor=white" alt="Descargar para Windows"/>
  </a>
  <a href="https://evagr11.github.io/Biblioteca/" target="_blank">
    <img src="https://img.shields.io/badge/Javadoc-C8963E?style=for-the-badge&logo=openjdk&logoColor=white" alt="Javadoc"/>
  </a>
  <a href="documentacion/Mi_biblioteca.pdf" target="_blank">
    <img src="https://img.shields.io/badge/Documentación-1C2B2A?style=for-the-badge&logo=latex&logoColor=white" alt="Documentación"/>
  </a>
  <a href="https://www.figma.com/proto/MBpHA9vkrAKfltr0WOi7qj/Mi-biblioteca-%E2%80%93-Prototipo-navegable?node-id=1-292&starting-point-node-id=1%3A292" target="_blank">
    <img src="https://img.shields.io/badge/Prototipo_Figma-2F6B5E?style=for-the-badge&logo=figma&logoColor=white" alt="Prototipo en Figma"/>
  </a>
</div>

<br>

<div align="center">
  <a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com/?font=JetBrains+Mono&size=18&duration=3500&pause=800&color=2F6B5E&center=true&vCenter=true&width=600&lines=JavaFX+%2B+FXML+%2B+SceneBuilder;Sketch+%E2%86%92+Wireframe+%E2%86%92+Prototipo;Modelo+%E2%86%94+Vista+%E2%86%94+Controlador;Documentado+con+Javadoc" alt="Typing SVG"/></a>
</div>

<div align="center">
  <img src=".github/readme/mockup.jpg" alt="Mi biblioteca en un portátil, con la ventana principal y la administración de libros" width="85%"/>
</div>

---

# 🚀 Sobre el Proyecto

**Mi biblioteca** es una aplicación de escritorio en **JavaFX** para saber qué libros hay en casa y dónde están. Permite añadir, modificar, eliminar y buscar **libros** y **autores**, y consultar la ficha de cada libro.

La hice siguiendo todo el proceso de diseño de una interfaz: **sketch** a mano, **wireframe** y **prototipo navegable** en Figma, vistas con **SceneBuilder** y, al final, modelo y controladores con el patrón **MVC**.

✨ **Características principales:**

- 🔎 **Ventana principal** con buscador por título o autor, filtros de tipo e idioma y la ficha del libro seleccionado.
- 📚 **Administración de libros**: título, autor, ubicación, edición, páginas, año, idioma, tipo (bolsillo, tapa blanda o tapa dura) y sinopsis.
- ✍️ **Administración de autores** con fechas de nacimiento y fallecimiento (`DatePicker`) y la lista de sus libros.
- 🗑️ **Confirmación antes de eliminar** en una ventana modal, para libros y para autores.
- ⚠️ **Validaciones**: campos obligatorios con asterisco y errores en rojo que explican qué corregir; si las páginas o el año no son números, no se cierra la app.
- 🔗 **Relación muchos a muchos** entre libros y autores: al eliminar un autor, desaparece también de sus libros.
- 🎨 **Estilo propio**: verde sereno, detalles dorados y la misma estructura en las tres ventanas.
- 📖 **Javadoc** en todas las clases y métodos, publicado en [GitHub Pages](https://evagr11.github.io/Biblioteca/).

---

# 🧠 Contexto del Proyecto

Es una práctica de la asignatura **Desarrollo de Interfaces** de 2º de **DAM**, hecha en cuatro partes:

<div align="center">

| Parte | Qué se hizo |
| :---- | :---------- |
| **1** | Diseño de la interfaz: sketch, wireframe y prototipo de las tres ventanas |
| **2** | Vistas con SceneBuilder, sin lógica |
| **3** | Clases del modelo, que guardan los libros y los autores |
| **4** | Controladores que unen el modelo con la vista y completan el MVC |

</div>

Toda la práctica está explicada en la [documentación en PDF](documentacion/Mi_biblioteca.pdf) (LaTeX, 42 páginas): requisitos, diseño, estilo visual, implementación, pruebas y código.

---

# 🎨 Del boceto a la aplicación

<table align="center">
  <tr>
    <td align="center" width="33%"><img src=".github/readme/boceto.jpg" alt="Sketch a mano de la ventana principal"/><br><em>1. Sketch a mano</em></td>
    <td align="center" width="33%"><img src=".github/readme/wireframe.jpg" alt="Wireframe en escala de grises de la ventana principal"/><br><em>2. <a href="https://www.figma.com/design/OKJrJVBE6Cq7DnDBW9bMlK/Mi-biblioteca-%E2%80%93-Wireframes">Wireframe en Figma</a></em></td>
    <td align="center" width="33%"><img src=".github/readme/prototipo.jpg" alt="Prototipo con color de la ventana principal"/><br><em>3. <a href="https://www.figma.com/proto/MBpHA9vkrAKfltr0WOi7qj/Mi-biblioteca-%E2%80%93-Prototipo-navegable?node-id=1-292&starting-point-node-id=1%3A292">Prototipo navegable</a></em></td>
  </tr>
</table>

| Ventana principal | Administración de libros |
| :---------------: | :----------------------: |
| <img src=".github/readme/principal.jpg" alt="Ventana principal con la tabla de libros, filtros y ficha"/> | <img src=".github/readme/libros.jpg" alt="Administración de libros con la tabla y el formulario"/> |
| *Buscador, filtros y ficha del libro.* | *Formulario para añadir, editar y eliminar.* |
| **Administración de autores** | **Confirmación al eliminar** |
| <img src=".github/readme/autores.jpg" alt="Administración de autores con fechas y lista de libros"/> | <img src=".github/readme/confirmar.jpg" alt="Ventana que pide confirmación antes de eliminar un libro"/> |
| *Fechas con selector y libros del autor.* | *Ventana modal antes de borrar.* |

<div align="center">

| Color | Uso |
| :---: | :-- |
| ![#2F6B5E](https://img.shields.io/badge/-%232F6B5E-2F6B5E?style=flat-square) | Botones principales y ventana activa |
| ![#C8963E](https://img.shields.io/badge/-%23C8963E-C8963E?style=flat-square) | Solo adorno, nunca en texto |
| ![#1C2B2A](https://img.shields.io/badge/-%231C2B2A-1C2B2A?style=flat-square) | Texto principal |
| ![#B2443A](https://img.shields.io/badge/-%23B2443A-B2443A?style=flat-square) | Errores y eliminar |

</div>

---

# 🛠️ Stack Tecnológico

<p align="center">
  <img src="https://img.shields.io/badge/Java_11-1C2B2A?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaFX_13-2F6B5E?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/SceneBuilder-C8963E?style=for-the-badge&logo=xml&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-1C2B2A?style=for-the-badge&logo=apache-maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/Figma-2F6B5E?style=for-the-badge&logo=figma&logoColor=white"/>
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
</p>

<div align="center">

| Componente | Tecnología |
| :--------- | :--------- |
| **Lenguaje** | `Java 11` |
| **Interfaz** | `JavaFX 13` (`javafx-controls`, `javafx-fxml`) |
| **Vistas** | `FXML` hechos con `SceneBuilder`, estilos `-fx-*` en línea |
| **Build** | `Maven` + `javafx-maven-plugin` (arquetipo `javafx-archetype-fxml`) |
| **Diseño** | `Figma` (wireframes y prototipo navegable) |
| **Documentación** | `Javadoc` + memoria en `LaTeX` |

</div>

---

# 📂 Estructura del Proyecto

```bash
Biblioteca/
│
├── pom.xml
├── docs/                                  # Javadoc generado (publicado en GitHub Pages)
├── documentacion/
│   └── Mi_biblioteca.pdf                  # Memoria de la práctica
│
└── src/main/
    ├── java/
    │   ├── module-info.java               # Abre el modelo a las tablas de JavaFX
    │   └── org/example/
    │       ├── App.java                   # Arranque, cambio de ventana y confirmación
    │       ├── PrincipalController.java   # Busca, filtra y muestra la ficha
    │       ├── LibrosAdminController.java # Añade, modifica y elimina libros
    │       ├── AutoresAdminController.java# Añade, modifica y elimina autores
    │       ├── ConfirmarController.java   # Respuesta del diálogo de eliminar
    │       └── model/
    │           ├── Libro.java
    │           ├── Autor.java
    │           ├── TipoLibro.java         # Bolsillo, tapa blanda, tapa dura
    │           └── Biblioteca.java        # Guarda libros y autores y los busca
    └── resources/org/example/
        ├── PrincipalView.fxml
        ├── LibrosAdminView.fxml
        ├── AutoresAdminView.fxml
        └── ConfirmarView.fxml
```

---

# 🚀 Cómo Utilizar el Proyecto

### 💻 Descargar para Windows

No hace falta tener Java instalado: la descarga lleva su propia versión.

1. Descarga `MiBiblioteca-windows.zip` de la [última versión](https://github.com/evagr11/Biblioteca/releases/latest) y descomprímelo.
2. Abre la carpeta `bin` y haz doble clic en `MiBiblioteca.bat` (si el Explorador oculta las extensiones, aparece como `MiBiblioteca`).

### 📋 Requisitos para compilarla

- **JDK 11** o superior
- **Maven** (o el que trae IntelliJ IDEA)

### ▶️ Ejecutar la aplicación

```bash
git clone https://github.com/evagr11/Biblioteca.git
cd Biblioteca
mvn clean javafx:run
```

En **IntelliJ IDEA** también se puede lanzar desde el panel de Maven: `Plugins → javafx → javafx:run`. Arranca con cinco libros y cinco autores de ejemplo.

### 📦 Generar el zip para Windows

```bash
mvn clean javafx:jlink
```

Crea `target/MiBiblioteca-windows.zip`, con la aplicación y un Java reducido para ejecutarla. Se genera para el sistema donde se compila: hecho en Windows, funciona en Windows.

### 📖 Ver la documentación

- **Javadoc** online en **[evagr11.github.io/Biblioteca](https://evagr11.github.io/Biblioteca/)**, o abriendo `docs/index.html` en el navegador.
- **Memoria de la práctica** en [`documentacion/Mi_biblioteca.pdf`](documentacion/Mi_biblioteca.pdf).

---

# 🎯 Mejoras futuras

- 💾 **Guardar los datos** en un archivo o en una base de datos; ahora están en memoria y se pierden al cerrar.
- 👥 **Varios autores por libro** desde el formulario: el modelo ya los admite, pero el desplegable solo deja elegir uno.
- 🌍 **Idiomas del filtro** sacados de los libros, en vez de «Español» e «Inglés» fijos.
- 🎨 **Estilos en una hoja CSS**, que también cambie el azul por defecto de la fila seleccionada al verde de la app.
- 📐 **Ventana adaptable**: ahora está pensada para 1180 píxeles de ancho.
- 📦 **Instalador `.exe`** con icono y acceso en el menú Inicio, con `jpackage`, en vez de abrirla con un `.bat`.

---

<div align="center">
  <p>Creado por <strong>Eva Gallardo</strong></p>
  <a href="https://github.com/evagr11" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub">
  </a>
  <a href="https://www.linkedin.com/in/eva-gallardo-romero-830362349/" target="_blank">
    <img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn">
  </a>
</div>

<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:1C2B2A,50:2F6B5E,100:C8963E&height=120&section=footer" width="100%"/>
</div>
