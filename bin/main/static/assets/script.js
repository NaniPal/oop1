  document.addEventListener("DOMContentLoaded", function () {
    const cartList = document.getElementById("cart-list");
    const buyNowButtons = document.querySelectorAll(".buy-now-button");

    buyNowButtons.forEach((button) => {
      button.addEventListener("click", function () {
        // Get the book image source from the parent element (imga div)
        const bookImageSrc = this.parentElement.querySelector("img").src;

        // Create a new list item (li) to represent the book in the cart
        const cartItem = document.createElement("li");
        cartItem.innerHTML = `<img src="${bookImageSrc}" alt="Book Image">`;

        // Append the cart item to the cart list
        cartList.appendChild(cartItem);
      });
    });
  });


document.getElementById("review-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const book = document.getElementById("book").value;
    const comment = document.getElementById("comment").value;

    const reviewData = { username, book, comment };

    fetch("/api/reviews", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(reviewData)
    })
    .then(response => {
        if (response.ok) {
            alert("Review added successfully!");
        } else {
            alert("Failed to add review. Please try again.");
        }
    })
    .catch(error => {
        console.error("Error occurred:", error);
    });
});
