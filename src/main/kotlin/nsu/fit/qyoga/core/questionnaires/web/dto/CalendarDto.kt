package nsu.fit.qyoga.core.questionnaires.web.dto

class CalendarDto (
    var mondayActions: List<Actions> = mutableListOf(),
    var tuesdayActions: List<Actions> = mutableListOf(),
    var wednesdayActions: List<Actions> = mutableListOf(),
    var thursdayActions: List<Actions> = mutableListOf(),
    var fridayActions: List<Actions> = mutableListOf(),
    var saturdayActions: List<Actions> = mutableListOf(),
    var sundayActions: List<Actions> = mutableListOf()
    )