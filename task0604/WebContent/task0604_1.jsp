<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
  background: radial-gradient(ellipse at bottom, #1b2735 0%, #090a0f 100%);
  height: 100vh;
  overflow: hidden;
  display: flex;
  font-family: 'Anton', sans-serif;
  justify-content: center;
  align-items: center;
  perspective: 600px;
}

div {
  transform-style: preserve-3d;
}

.camera {
  // &.-x {
  //   transform: rotateX(-60deg);
  // }
  
  &.-y {
    animation: rotate 30s linear infinite;
  }
}

.fireworks {
  &:nth-child(1) {
    transform: translate3d(0, -200px, 100px);
    --color: rgb(250, 40, 40);
  }
  
  &:nth-child(2) {
    transform: translate3d(160px, -100px, -160px);
    --color: rgb(50, 240, 40);
    
    .line .spark {
      animation-delay: -0.5s;
    }
  }
  
  &:nth-child(3) {
    transform: translate3d(-160px, 0, -160px);
    --color: rgb(50, 80, 250);
    
    .line .spark {
      animation-delay: -1s;
    }
  }
}

.spark {
  position: absolute;
  // width: 400px;
  // height: 400px;
  // background: rgba(#fff, 0.1);
  transform-origin: 0 0;
}

.fire {
  position: absolute;
  left: -3px;
  width: 5px;
  height: 5px;
  background: rgb(250, 40, 40);
  // background: var(--color);
  
  &::before {
    content: '';
    position: absolute;
    width: 100%;
    height: 100%;
    background: rgb(230, 200, 40);
    transform: translateZ(0.1px);
  }
}

.line {
  @for $i from 1 through 200 {
    &:nth-child(#{$i}) {
      transform: rotateY(random(360) + 0deg);
      
      .spark {
        // transform-origin: random(100) + 0% random(100) + 0%;
        // width: random(200) + 200px;
        // height: random(200) + 200px;
        animation:
          spark#{$i} 5s cubic-bezier(0.390, 0.575, 0.565, 1.000) infinite,
          opacity 5s ease-out infinite;
      }
      
      .fire {
        animation: fire random(1000) + 1000ms random(1000) * -1ms linear infinite;
      }
      
      $deg: random(360) + 0deg;
      
      @keyframes spark#{$i} {
        0% {
          transform: translateY(random(150) + 500px);
        }

        50% {
          transform: translateY(0);
        }

        // 100% {
        //   transform: translateY(0) rotateZ(random(60) + 30deg);
        // }
        
        100% {
          transform: rotateZ($deg) translateX(random(200) + 100px);
        }
      }
    }
  }
}

@keyframes opacity {
  0% {
    opacity: 0;
  }
  
  30% {
    opacity: 1;
  }
  
  40% {
    opacity: 0;
  }
  
  50% {
    opacity: 0;
  }
  
  55% {
    opacity: 1;
  }
  
  85% {
    opacity: 1;
  }
  
  100% {
    opacity: 0;
  }
}

@keyframes fire {
  0% {
    transform: rotateX(0deg) rotateY(0deg) rotateZ(0deg);
  }
  
  100% {
    transform: rotateX(360deg * 1) rotateY(360deg * 2) rotateZ(360deg * 3);
  }
}

@keyframes rotate {
  0% {
    transform: rotateY(0deg);
  }
  
  100% {
    transform: rotateY(360deg);
  }
}
</style>
</head>
<body>
<div class="camera -x">
	<div class="camera -y">
		<div class="camera -z">
				<div class="fireworks">
						<div class="line">
							<div class="spark">
								<div class="fire"></div>
							</div>
						</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>