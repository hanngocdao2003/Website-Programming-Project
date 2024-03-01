const radioButtons = document.querySelectorAll('input[type="radio"]');
radioButtons.forEach((radio) => {
    radio.addEventListener('change', () => {
        radioButtons.forEach((rb) => {
            if (rb !== radio) {
                rb.checked = false;
            }
        });
    });
});

const numberInput = document.getElementById('number');
const totalSpan = document.getElementById('total');

function updateTotal() {
    const quantity = parseInt(numberInput.value);
    const pricePerProduct = 290000;
    const total = quantity * pricePerProduct;
    const formatter = new Intl.NumberFormat('vi-VN', {
        style: 'currency',
        currency: 'VND',
    });
    totalSpan.textContent = formatter.format(total);
}


function increaseValue() {
    let value = parseInt(numberInput.value);
    value++;
    numberInput.value = value;
    updateTotal();
}

function decreaseValue() {
    let value = parseInt(numberInput.value);
    if (value > 1) {
        value--;
        numberInput.value = value;
        updateTotal();
    }
}
numberInput.addEventListener('input', updateTotal);
updateTotal();