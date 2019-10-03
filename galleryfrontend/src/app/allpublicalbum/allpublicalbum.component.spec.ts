import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllpublicalbumComponent } from './allpublicalbum.component';

describe('AllpublicalbumComponent', () => {
  let component: AllpublicalbumComponent;
  let fixture: ComponentFixture<AllpublicalbumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllpublicalbumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllpublicalbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
