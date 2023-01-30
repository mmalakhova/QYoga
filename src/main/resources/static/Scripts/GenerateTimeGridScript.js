const hours = ['1:00','2:00','3:00','4:00','5:00','6:00','7:00','8:00','9:00','10:00','11:00','12:00',
    '13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00','22:00','23:00'];
const timeTag = document.querySelector(".week-grid-times-hours")

const timeGrid = () => {
    let elements = "";
    for(let i=0; i<hours.length;i++){
        elements+= `<div class=week-grid-times-hours-cell>${hours[i]}</div>`
    }
    elements+= `<div class=week-grid-times-hours-cell></div>`
    timeTag.innerHTML = elements;
}
timeGrid()