#Imports Data
data <- read.table("C:/Users/ryann/Desktop/B10Prime/PrimeCount(100,000,000;10,000)/PrimeCounts/PrimeStats.txt")
data[49999,1]
remove(conglomData)

#Initalizes Container Variables
conglomData <- data.frame(1,1)
conglomData <- cbind(c(0,1,2,3,4,5,6,7,8,9),conglomData[,1])
conglomAvg <- vector()
conglomStDev <- vector()
conglomT <- vector()

#Sums Data Points and Conglomerates the Averages
for(i in 1:length(data[,1])) {
  idx <- substr(data[i,1],0,1)
  
  if(idx == "A"){
    conglomAvg <- c(conglomAvg,data[i,2])
  }
  
  if(idx != "S" & idx != "A"){
  idx <- as.numeric(substr(data[i,1],0,1))+1
  conglomData[idx,2] = as.numeric(conglomData[idx,2])+as.numeric(data[i,2])
  }
}

#Calculates the T statistic of each sample
conglomT <- round((conglomAvg - mean(conglomAvg))/sd(conglomAvg),1)
print(conglomData)

#Plots the Mean Frequency of Digits
barplot(height = conglomData[,2]/10000,names.arg = conglomData[,1], main = "Mean Frequency of Digits in 10000 samples of 100 primes <10000000", xpd = FALSE, ylim = c(0,100),col = "cadetblue1")
barplot(height = Matrix::as.matrix((conglomData[,2]/sum(conglomData[,2])*100)), beside = FALSE, space = 0.3, main = "Mean Frequency of Digits in 10000 samples of 100 primes <10000000", xpd = FALSE, ylim = c(0,100),legend.text = paste(conglomData[,1],": Rel Freq = ", Matrix::as.matrix((conglomData[,2]/sum(conglomData[,2])*100)),"%"),col = c("aquamarine","cadetblue1","darkorchid3","darkseagreen1","green","darkslategray1","dodgerblue1","cyan3","darkviolet","deeppink2"),xlim=c(0,3),width=1)


#Plots a Histogram of the Average Digit
x <- seq(-3,3,0.1)
y <- dt(x,10000)
hist(conglomT,plot=TRUE,freq=FALSE,xlim=c(-5,5),ylim= c(0,0.5),breaks=seq(-5,5,0.20),xlab="t",ylab = "P(T=t)",main = "Histogram of Average Digit w/ T_10000 LoBF")
lines(x,y,lty=1,col="blue")
