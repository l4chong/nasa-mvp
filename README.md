# Instructions
❏ Connect to NASA picture of the day REST API and parse the JSON response payload
❏ Display error message if server response code is neither 200 nor 202.
❏ Display NASA picture of the day in center of screen, maintain aspect ratio and make sure height is half of the screen height.
❏ Display the picture title below the picture, center align the text, word wrap if more lines are needed to render the title.
❏ Create custom transition, tap image to display new screen with image transitioning from original size to full screen size in the
new screen and have the text fade out. Set the transition time to 0.35 sec.
❏ Make any part or all of the above code support unit test and provide unit test.

# Assumptions

1. prioritize Aspect Ratio over height, it's better to see the whole picture 
for example https://www.nasa.gov/sites/default/files/styles/full_width_feature/public/thumbnails/image/pia21722.jpg?itok=HK348ZdE

2. Title is not going to be really long that I it would go more than 4 lines. (otherwise I would have added scrollview)

3. Assumed min 21 supported 

4. Assumed full screen meant will cover the whole screen regardless of aspect ratio (otherwise remove centercrop)

# Two projects 

1. PictureOfTheDay - Traditional implementation (Done)
2. MvpPictureOfTheDay - Attempt MVP implementaiton (In Progress)