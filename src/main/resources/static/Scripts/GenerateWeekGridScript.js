const weekTag = document.querySelector(".week-grid-header")


const weekGrid = () => {
    // Дата
    // 'August 19, 1975 23:15:30'
    //const date = new Date([[${date}]]);
    let date = new Date();
    // День недели
    // от 0 (воскресенье) до 6 (суббота)
    let weekDay = date.getDay();
    // День месяца
    let monthDay = date.getDate();
    // Номер месяца (индекс)
    let monthId = date.getMonth();

    // сохранение названия всех дней недели в массиве
    let week = ["Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"];
    // Кол-во дней в каждом месяце
    let countDayOnMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    // День месяца, понедельника текущей недели
    let countMonthDay;
    let elements = "";
    // Проверка, что бы всегда начинать выстраивать текущую неделю с понедельника
    if (weekDay > 1) {
        countMonthDay = monthDay - (weekDay - 1);
    } else if (weekDay === 0) {
        countMonthDay = monthDay - 6;
    } else {
        countMonthDay = monthDay;
    }
    // генерация результата
    for (let i = 0; i < week.length; i++) {
        // Если countMonthDay больше кол-ва дней в месяце
        // дни начинаются сначала
        if ((countMonthDay + i) > countDayOnMonth[monthId]) {
            let count = countDayOnMonth[monthId] - (countMonthDay + (week.length - 1));
            //result.push([`day: ${week[i]}`, `date: ${count + i}`]);
            elements += `<div class="week-grid-header-day">`;
            elements += `<span class="week-grid-header-day-date">`;
            elements += `<span class="week-grid-header-day-day">${count + i}</span>`;
            elements += `<span class="week-grid-header-day-sub">`;
            elements += `<span class="week-grid-header-day-weekday">${week[i]}</span></span></span>`;
            elements+= `</div>`

        } else {
            //result.push([`day: ${week[i]}`, `date: ${countMonthDay + i}`]);
            elements += `<div class="week-grid-header-day">`;
            elements += `<span class="week-grid-header-day-date">`;
            elements += `<span class="week-grid-header-day-day">${countMonthDay + i}</span>`;
            elements += `<span class="week-grid-header-day-sub">`;
            elements += `<span class="week-grid-header-day-weekday">${week[i]}</span></span></span>`;
            elements+= `</div>`
        }

        weekTag.innerHTML = elements;
    }
}
weekGrid();


