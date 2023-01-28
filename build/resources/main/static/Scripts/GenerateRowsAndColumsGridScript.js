const rowsTag = document.querySelector(".week-grid-rows")

const rowsGrid = () => {
    let elements = "";
    for(let i=0; i<24;i++){
        elements+= `<div class=week-grid-rows-row></div>`
    }
    rowsTag.innerHTML = elements;
}
rowsGrid()

/*
const columnsTag = document.querySelector(".week-grid-columns")
const columnsGrid = () => {
    let elements = "";
    for(let i=0; i<7;i++){
        elements+= `<div class=week-grid-columns-column></div>`
    }
    columnsTag.innerHTML = elements;
}
columnsGrid()*/
