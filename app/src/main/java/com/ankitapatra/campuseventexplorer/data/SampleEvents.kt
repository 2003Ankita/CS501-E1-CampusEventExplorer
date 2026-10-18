
package com.ankitapatra.campuseventexplorer.data

import com.ankitapatra.campuseventexplorer.model.CampusEvent

object SampleEvents {

    val events: List<CampusEvent> = listOf(
        CampusEvent(
            id = 1L,
            title = "Tech & AI Innovation Night",
            category = "Technology",
            location = "BU Center for Computing & Data Sciences",
            time = "Oct 21, 2026 • 6:00 PM",
            description = "Explore exciting developments in artificial intelligence, software engineering, and emerging technologies. Connect with fellow students, share ideas, and discover innovative projects."
        ),
        CampusEvent(
            id = 2L,
            title = "Fall Music Festival",
            category = "Music",
            location = "BU Beach",
            time = "Oct 23, 2026 • 5:30 PM",
            description = "Celebrate the fall semester with live music, student performances, and an energetic campus atmosphere. Enjoy an evening of creativity and community."
        ),
        CampusEvent(
            id = 3L,
            title = "Career Connect Expo",
            category = "Career",
            location = "George Sherman Union",
            time = "Oct 26, 2026 • 11:00 AM",
            description = "Meet professionals, explore internship opportunities, and learn about career paths in technology, business, and other industries."
        ),
        CampusEvent(
            id = 4L,
            title = "Campus Wellness Day",
            category = "Wellness",
            location = "FitRec Center",
            time = "Oct 28, 2026 • 10:00 AM",
            description = "Take a break from academics with wellness activities, mindfulness sessions, fitness challenges, and practical stress-management tips."
        ),
        CampusEvent(
            id = 5L,
            title = "Global Culture Carnival",
            category = "Culture",
            location = "Marsh Plaza",
            time = "Oct 30, 2026 • 4:00 PM",
            description = "Experience cultural performances, international traditions, student showcases, and activities celebrating the diversity of the campus community."
        ),
        CampusEvent(
            id = 6L,
            title = "Hackathon: Build for Good",
            category = "Technology",
            location = "BU Spark! Innovation Center",
            time = "Nov 2, 2026 • 9:00 AM",
            description = "Collaborate with students to design and prototype technology solutions for real-world challenges. All experience levels are welcome."
        ),
        CampusEvent(
            id = 7L,
            title = "Terrier Sports Night",
            category = "Sports",
            location = "Agganis Arena",
            time = "Nov 5, 2026 • 7:00 PM",
            description = "Celebrate school spirit with fellow Terriers through an exciting sports-themed campus gathering, interactive activities, and community fun."
        ),
        CampusEvent(
            id = 8L,
            title = "Creative Arts Showcase",
            category = "Arts",
            location = "BU College of Fine Arts",
            time = "Nov 9, 2026 • 3:00 PM",
            description = "Discover student artwork, creative performances, and inspiring projects across visual arts, music, and design."
        )
    )
}
