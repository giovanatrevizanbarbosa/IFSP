function toggleTheme() {
    const toggleButton = document.querySelector('#toggle-theme');

    toggleButton.addEventListener("click", () => {
        const theme = document.documentElement.getAttribute("data-bs-theme");
        const newTheme = theme === "dark" ? "light" : "dark";
        document.documentElement.setAttribute("data-bs-theme", newTheme);

        const iconClass = newTheme === "dark" ? "bi bi-moon-fill" : "bi bi-brightness-high-fill";
        toggleButton.className = "btn toggle-theme " + iconClass;
    })
}

toggleTheme();