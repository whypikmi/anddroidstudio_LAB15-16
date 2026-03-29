package com.telyatnikova.studentplanner.data

data class TimingItem(
    val id: String,
    val dayOfWeek: String,
    val time: String,
    val subjectName: String,
    val classroom: String,
    val professor: String
)

val sampleTiming = listOf(
    TimingItem(
        id = "1",
        dayOfWeek = "Понедельник",
        time = "08:30 - 10:00",
        subjectName = "Разработка мобильных приложений",
        classroom = "1-02",
        professor = "Леонтьев Д.А."
    ),
    TimingItem(
        id = "2",
        dayOfWeek = "Понедельник",
        time = "10:10 - 11:40",
        subjectName = "Системное программирование",
        classroom = "3-02",
        professor = "Токаев Т.И."
    ),
    TimingItem(
        id = "3",
        dayOfWeek = "Вторник",
        time = "08:30 - 10:00",
        subjectName = "Управление проектами",
        classroom = "3-12",
        professor = "Трошина О.В."
    ),
    TimingItem(
        id = "4",
        dayOfWeek = "Среда",
        time = "13:50 - 15:20",
        subjectName = "Разработка программных модулей",
        classroom = "3-09",
        professor = "Донскова Д.А."
    ),
    TimingItem(
        id = "5",
        dayOfWeek = "Четверг",
        time = "12:10 - 13:40",
        subjectName = "Разработка мобильных приложений",
        classroom = "1-02",
        professor = "Леонтьев Д.А."
    ),
    TimingItem(
        id = "6",
        dayOfWeek = "Пятница",
        time = "08:30 - 10:00",
        subjectName = "Английский язык",
        classroom = "2-20",
        professor = "Пенькова О.В."
    )
)