function Validator(options) { 

    function getParent(element, selector) {
        while (element.parentElement) {
            if (element.parentElement.matches(selector)){
                return element.parentElement;
            }
            element = element.parentElement;
        }
    }

    var selectorRules = {}

    function validate (inputElement, rule) {

        var errorMessage ;
        var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);

        var rules = selectorRules[rule.selector];

        for (var i=0; i< rules.length; ++i){ 
            switch (inputElement.type) {
                case 'radio':
                case 'checkbox' :
                    errorMessage = rules[i] (
                        formElement.querySelector(rule.selector +  ':checked')
                    );
                    break;    
                default:
                    errorMessage = rules[i](inputElement.value);
            }
            if (errorMessage) 
                break;

            errorMessage = rules[i](inputElement.value);
            if(errorMessage) break; 
        }

        if (errorMessage) {
        var errorMessage = errorMessage;
            errorElement.innerText = errorMessage;
            getParent(inputElement, options.formGroupSelector).classList.add('invalid');
        } else {
            errorElement.innerText = '';  
            getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
        }

        return  !errorMessage;
    }

    var formElement = document.querySelector(options.form);
    if (formElement) {

        formElement.onsubmit = function(e){
            e.preventDefault();
            var isFormValid =true;
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid){
                    isFormValid =false;
                }
            });


            if(isFormValid) {
                if (typeof options.onSubmit === 'function'){
                    var enableInputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {

                        switch(input.type){

                            case 'radio':
                                values[input.name] = formElement.querySelector('input[name="' + input.name + '"]:checked').value;
                                break;
                            case 'checkbox':
                                if (!input.matches(':checked')) return values;
                                if (!Array.isArray(values[input.name])) {
                                    values[input.name] = [];
                                }
                                values[input.name].push(input.value);
                                break;
                            case 'file':
                                values[input.name] = input.files;
                                break;
                            default :
                                values[input.name] = input.value;
                        }
                    return values;
                    }, {});
                    options.onSubmit(formValues);
                }

                else {
                    formElement.submit();
                }
            }
        }

        options.rules.forEach(function (rule) {

            if(Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);

            } else {
                selectorRules[rule.selector] = [rule.test];
            }



            var inputElements = formElement.querySelectorAll(rule.selector);

            Array.from(inputElements).forEach(function (inputElement ) {

                if(inputElement) {

                    inputElement.onblur = function () {
                        validate(inputElement, rule);          
                    }
    
                    inputElement.oninput = function () {
                        var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
                        errorElement.innerText = ' '; 
                        inputElement.parentElement.classList.remove('invalid'); 
                    }
                }
            });
            });
        console.log(selectorRules);
    }
}

Validator.isRequired = function (selector, message) {
    return {
        selector : selector,
        test: function (value) {
            return value? undefined : message || 'Vui lòng nhập trường này'   
        }
    };
}

Validator.isEmail = function (selector, message) {
    return {
        selector : selector,
        test: function(value) {
            regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/ ;
            return regex.test(value) ? undefined : message || 'Vui lòng nhập email';
        }
    };
}

///Rule password
Validator.minLength = function (selector, min, message) {
    return {
        selector : selector,
        test: function(value) {
            return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} kí tự`;
        }
    };
}

Validator.isConfirmed = function (selector, getConfirmValue, message){
    return{
        selector : selector,
        test : function(value){
            return value === getConfirmValue() ? undefined : message || 'Giá trị nhập vào không chính xác';
        }
    }
}

Validator.isPrice = function (selector, message) {
    return { 
        selector : selector,
        test: function (value) {
            return value > 0 ? undefined : message ;
        }
    };
}

Validator.isQuantity = function (selector, message) {
    return { 
        selector : selector,
        test: function (value) {
            return value > 0 ? undefined : message || 'Yêu cầu nhập số sản phẩm cần mua';
        }
    };
}