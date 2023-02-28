const daysTag = document.querySelector(".days"),
    currentDate = document.querySelector(".current-date"),
    prevNextIcon = document.querySelectorAll(".icons span");

// getting new date, current year and month
let date = new Date(),
    currDay = date.getDate(),
    currYear = date.getFullYear(),
    currMonth = date.getMonth();

// storing full name of all months in array
const months = ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
    "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"];

const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(), // получение первого дня месяца
        lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(), // получение последнего числа месяца
        lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(), // получение последнего дня месяца
        lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // получение последней даты предыдущего месяца
    let liTag = "";
    let index = 0;
    let weekNum = 0;
    liTag+= `<ul class="week" hx-trigger="click"
                              hx-get="@{/schedule/${currYear}/${currMonth}/${weekNum}"
                              hx-target="#schedule">`;
    for (let i = firstDayofMonth; i > 1; i--) { // создание списка последних дней предыдущего месяца
        liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
        index++;
    }

    for (let i = 1; i <= lastDateofMonth; i++) { // создание списка всех дней текущего месяца
        // добавление активного класса в li, если текущий день, месяц и год совпадают
        if(index === 7){
            weekNum++
            liTag+= `</ul>`;
            liTag+= `<ul class="week" hx-trigger="click"
                                      hx-get="@{/schedule/${currYear}/${currMonth}/${weekNum}"
                                      hx-target="#schedule">`;
            index=0;
        }
        let isToday = i === currDay && currMonth === new Date().getMonth()
        && currYear === new Date().getFullYear() ? "active" : "";
        liTag += `<li class="${isToday}">${i}</li>`;
        index++;
    }

    for (let i = lastDayofMonth; i < 6; i++) { // создание списка первых дней следующего месяца
        liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
    }

    liTag+= `</ul>`;
    currentDate.innerText = `${months[currMonth]}\n${currYear}`; // передача текущего месяца и года в качестве текста текущей даты
    daysTag.innerHTML = liTag;
}
renderCalendar();

prevNextIcon.forEach(icon => { // getting prev and next icons
    icon.addEventListener("click", () => { // adding click event on both icons
        // if clicked icon is previous icon then decrement current month by 1 else increment it by 1
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

        if(currMonth < 0 || currMonth > 11) { // if current month is less than 0 or greater than 11
            // creating a new date of current year & month and pass it as date value
            date = new Date(currYear, currMonth);
            currYear = date.getFullYear(); // updating current year with new date year
            currMonth = date.getMonth(); // updating current month with new date month
        } else {
            date = new Date(); // pass the current date as date value
        }
        renderCalendar(); // calling renderCalendar function
    });
});