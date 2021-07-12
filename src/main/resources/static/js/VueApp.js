var creditCalculator = new Vue({
    el: '#creditCalculator',
    data: {

        percentRate:14.9,

        minCreditSum:100000,
        maxCreditSum:5000000,
        currentCreditSum: 100000,


        minMonthAmount:12,
        maxMonthAmount:60,
        currentMonthAmount:60,
        responseCreditData: undefined,

        showPaymentData: false,
        monthPayment:0,
        totalSumPayments:0,
        overPayment:0

    },
    methods:{
        checkInputSumRange: function () {
         if(this.currentCreditSum<100000) this.currentCreditSum = 100000;
         if(this.currentCreditSum>5000000) this.currentCreditSum = 50000000;
         },
        checkInputSumForCharacters: function(){
            if(isNaN(this.currentCreditSum))  {
            this.currentCreditSum=this.currentCreditSum.replace(/[^0-9]/g, '');
            console.log('deleting characters')
            }
        },

        


        calculateCreditInformation: function () {
            this.requestCreditData = {
                creditSum: this.currentCreditSum,
                monthAmount: this.currentMonthAmount,
                percentRate: this.percentRate
            };
            console.log( this.requestCreditData)
            const requestJson = JSON.stringify(this.requestCreditData);

            axios.post(window.location.href+'calculateCredit', this.requestCreditData)
                .then((response) => {
                   this.responseCreditData = response.data;

                    this.monthPayment = response.data[0].monthPayment;
                    this.totalSumPayments = (response.data.reduce((total,current)=>total + current.monthPayment,0)).toFixed(2);
                    this.overPayment = (this.totalSumPayments - this.currentCreditSum).toFixed(2);
                    this.showPaymentData = true;


                })
                .catch(e => {
                    console.log('Error Send');
                })
        }



    }
})