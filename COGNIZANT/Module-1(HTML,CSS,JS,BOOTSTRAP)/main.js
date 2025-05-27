console.log("Local Community Event Portal script loaded.");
alert("Welcome to the Local Community Event Portal!");
document.querySelector("form").addEventListener("submit", function (e) {
  e.preventDefault();
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const eventType = document.getElementById("eventType").value;
  const date = document.getElementById("eventDate").value;
  const output = document.querySelector("output");
  if (!name || !email || !eventType || !date) {
    output.textContent = "Please fill in all required fields.";
  } else {
    output.textContent = `Thank you ${name}! You are registered for the ${eventType} event on ${date}.`;
  }
});
document.getElementById("phone").addEventListener("blur", function () {
  const phone = this.value;
  const phoneRegex = /^[0-9]{10}$/;
  if (!phoneRegex.test(phone)) {
    alert("Please enter a valid 10-digit phone number.");
  }
});
const img = document.querySelector("img");
img.addEventListener("dblclick", function () {
  img.style.transform = "scale(1.5)";
  img.style.transition = "transform 0.5s ease";
  setTimeout(() => {
    img.style.transform = "scale(1)";
  }, 1000);
});
const modalBtn = document.querySelector(".btn-outline-primary");
if (modalBtn) {
  modalBtn.addEventListener("click", () => {
    const modal = new bootstrap.Modal(document.getElementById("eventModal"));
    modal.show();
  });
}
const saveBtn = document.querySelector("button.btn-primary");
const clearBtn = document.querySelector("button.btn-secondary");
const prefSelect = document.querySelector("select.form-select");
saveBtn.addEventListener("click", () => {
  const selected = prefSelect.value;
  localStorage.setItem("preferredEvent", selected);
  alert("Preference saved!");
});
clearBtn.addEventListener("click", () => {
  localStorage.removeItem("preferredEvent");
  alert("Preferences cleared!");
});
window.addEventListener("DOMContentLoaded", () => {
  const saved = localStorage.getItem("preferredEvent");
  if (saved) prefSelect.value = saved;
});
document.querySelector(".btn-info").addEventListener("click", () => {
  const locationText = document.querySelector("#nearby p");
  if (!navigator.geolocation) {
    locationText.textContent = "Geolocation is not supported by your browser.";
    return;
  }
  navigator.geolocation.getCurrentPosition(
    position => {
      const { latitude, longitude } = position.coords;
      locationText.textContent = `Your location: Lat ${latitude.toFixed(4)}, Lng ${longitude.toFixed(4)}`;
    },
    error => {
      locationText.textContent = "Error fetching location.";
    }
  );
});
