document.addEventListener('DOMContentLoaded', function() {
    let sliderIndex = 0;
    const slides = document.querySelectorAll('.slider img');
    const totalSlides = slides.length;

    const updateSlider = () => {
        const slideWidth = slides[0].offsetWidth + 20; // 이미지 너비 + 마진(간격)
        const additionalOffset = 19; // 추가로 이동할 2px
        const newTransform = -(sliderIndex * slideWidth + sliderIndex * additionalOffset);
        document.querySelector('.slider').style.transform = `translateX(${newTransform}px)`;
    };

    document.querySelector('.left-btn').addEventListener('click', function() {
        if (sliderIndex > 0) {
            sliderIndex--;
        } else {
            sliderIndex = totalSlides - 7; // 마지막 7개 이미지로 이동
        }
        updateSlider();
    });

    document.querySelector('.right-btn').addEventListener('click', function() {
        if (sliderIndex < totalSlides - 7) {
            sliderIndex++;
        } else {
            sliderIndex = 0; // 처음으로 이동
        }
        updateSlider();
    });

    window.addEventListener('resize', updateSlider); // 창 크기 변경 시 슬라이더 업데이트
});